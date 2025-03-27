<template>
  <div class="manage">
    <el-dialog
      :title="dialogForm.type === 'add' ? '新增用户' : '更新用户'"
      :visible.sync="dialogForm.isShow"
    >
      <el-form ref="form" label-width="100px" :model="dialogForm.formData" size="mini">
        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item label="入职流程名称" style="display:inline-block;width:300px" prop="processName">
            <el-input
              placeholder="请输入入职流程名称"
              v-model.trim="dialogForm.formData.processName"
            />
          </el-form-item>
        </el-form-item>

        <el-form-item label="入职流程详情" label-width="140px" style="width: 450px" prop="processDetails">
          <el-input
            type="textarea"
            placeholder="请输入入职流程详情"
            v-model.trim="dialogForm.formData.processDetails"
          />
        </el-form-item>

        <el-form-item label="入职流程顺序（从小到大排序）" label-width="140px" style="width:450px" prop="sort">
          <el-input-number v-model="dialogForm.formData.sort" label="请输入"/>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogForm.isShow = false">取消</el-button>
        <el-button type="primary" @click="confirm">确定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="角色分配" :visible.sync="roleDialog.isShow">
      <el-checkbox-group v-model="roleDialog.checkedData">
        <el-checkbox v-for="(item,index) in roleDialog.roleData" :key="index" :label="item.id" style="margin: 10px"
                     border>{{ item.name }}
        </el-checkbox>
      </el-checkbox-group>
      <div slot="footer" class="dialog-footer">
        <el-button @click="roleDialog.isShow = false">取消</el-button>
        <el-button type="primary" @click="handleSetRole">确定</el-button>
      </div>
    </el-dialog>

    <div style="margin-bottom: 10px">
      <el-button type="primary" @click="handleAdd" size="mini"
      >新增 <i class="el-icon-circle-plus-outline"></i>
      </el-button>
    </div>

    <!------------------------- 搜索 ------------------------------------>
    <div class="manage-header">
      <el-form label-width="auto" :model="searchForm.formData"
               :inline="true" size="mini">
        <el-form-item label="任务名称" prop="taskName">
          <el-input placeholder="请输入需要查询任务的员工姓名" v-model="searchForm.formData.taskName"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search" size="mini">搜索 <i class="el-icon-search"/></el-button>
        </el-form-item>
      </el-form>
    </div>
    <!---------------------------- 数据表格----------------------------------->
    <div class="common-table">
      <el-table
        :data="table.tableData"
        height="85%"
        border
        stripe
        row-key="id"
        :header-cell-style="{background: '#eef1f6',color: '#606266',
        textAlign:'center',fontWeight:'bold',borderWidth:'3px'}"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="50" align="center"/>
        <el-table-column prop="processName" label="任务名称" min-width="50" align="center"/>
        <el-table-column prop="processDetails" label="任务详情" min-width="125" align="center"/>
        <el-table-column prop="createStaffName" label="任务创建人" min-width="125" align="center"/>
        <el-table-column prop="createTime" label="创建时间" min-width="200" align="center"/>
        <el-table-column prop="updateTime" label="更新时间" min-width="200" align="center"/>
        <el-table-column label="操作" width="280" fixed="right" align="center">
          <template slot-scope="scope">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)"
            >编辑 <i class="el-icon-edit"></i
            ></el-button>
            <el-popconfirm
              style="margin-left:10px;margin-right:10px"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="你确定删除吗？"
              @confirm="handleDelete(scope.row.id)"
            >
              <el-button size="mini" type="danger" slot="reference"
              >删除 <i class="el-icon-remove-outline"></i
              ></el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        class="pager"
        layout="total,sizes,prev,pager,next,jumper"
        :page-size="table.pageConfig.size ? table.pageConfig.size : 10"
        :page-sizes="[5, 10, 15, 20]"
        :total="table.pageConfig.total"
        :current-page.sync="table.pageConfig.current"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      ></el-pagination>
    </div>
  </div>
</template>
<script>
import {
  add,
  deleteBatch,
  deleteOne,
  edit,
  getList,
  setRole
} from '../../../api/task'

import { mapState } from 'vuex'

export default {
  name: 'taskManager',
  data () {
    return {
      dialogForm: {
        type: 'add', // add为新增，edit为编辑
        isShow: false,
        deptList: [],
        formData: {}
      },
      searchForm: {
        deptList: [],
        formData: {}
      },
      roleDialog: {
        isShow: false,
        roleData: [],
        checkedData: []
      },
      table: {
        tableData: [],
        pageConfig: {
          total: 10, // 记录总数
          current: 1, // 起始页
          size: 10 // 每页展示的记录数
        }
      },
      ids: [],
      staffId: 0, // 默认为0
      subDeptList: []
    }
  },
  computed: {
    ...mapState('token', ['token']),
    headers () {
      return { token: this.token }
    }
  },
  methods: {
    // 点击新增按钮，弹出对话框
    handleAdd () {
      this.dialogForm.isShow = true
      this.dialogForm.type = 'add'
      this.dialogForm.formData = {}
    },
    handleDelete (id) {
      deleteOne(id).then(
        response => {
          if (response.code === 200) {
            this.$message.success('删除成功！')
            this.loading()
          } else {
            this.$message.error('删除失败！')
          }
        }
      )
    },
    handleDeleteBatch () {
      deleteBatch(this.ids).then(response => {
        if (response.code === 200) {
          this.$message.success('批量删除成功！')
          this.loading()
        } else {
          this.$message.error('批量删除失败！')
        }
      })
    },
    handleEdit (row) {
      this.dialogForm.isShow = true
      this.dialogForm.type = 'edit'
      this.dialogForm.formData = row
    },
    confirm () {
      this.dialogForm.formData.deptId = this.searchForm.formData.deptId
      // 通过type来判断是新增还是编辑
      if (this.dialogForm.type === 'add') {
        add(this.dialogForm.formData).then((response) => {
          if (response.code === 200) {
            this.$message.success('添加成功！')
            this.dialogForm.isShow = false
            this.loading()
          } else {
            this.$message.error('添加失败！')
          }
        })
      } else {
        edit(this.dialogForm.formData.id, this.dialogForm.formData).then((response) => {
          if (response.code === 200) {
            this.$message.success('修改成功！')
            this.dialogForm.isShow = false
            this.loading()
          } else {
            this.$message.error('修改失败！')
          }
        })
      }
    },
    search () {
      this.loading()
    },
    // 重置搜索表单
    reset () {
      this.searchForm.formData = {}
      this.loading()
    },
    handleSizeChange (size) {
      this.table.pageConfig.size = size
      this.loading()
    },
    handleCurrentChange (current) {
      this.table.pageConfig.current = current
      this.loading()
    },
    handleSelectionChange (list) {
      this.ids = list.map(item => item.id)
    },
    // 加载数据
    loading () {
      getList({
        current: this.table.pageConfig.current,
        size: this.table.pageConfig.size,
        taskName: this.searchForm.formData.taskName
      }).then(response => {
        if (response.code === 200) {
          this.table.tableData = response.data.list
          this.table.pageConfig.total = response.data.total
        } else {
          this.$message.error(response.message)
        }
      })
    },
    handleSetRole () {
      setRole(this.staffId, this.roleDialog.checkedData).then(
        response => {
          if (response.code === 200) {
            this.roleDialog.isShow = false
            this.$message.success('角色分配成功！')
          } else {
            this.$message.error('角色分配失败！')
          }
        }
      )
    }
  },
  created () {
    this.loading()
  }
}
</script>
