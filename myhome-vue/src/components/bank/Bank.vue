<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
<!--      <el-tooltip effect="dark" placement="right"-->
<!--                  v-for="item in banks.slice((currentPage-1)*pagesize,currentPage*pagesize)"-->
<!--                  :key="item.id">-->
<!--        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>-->
<!--        <p slot="content" style="font-size: 13px;margin-bottom: 6px">-->
<!--          <span>{{item.answer}}</span>-->
<!--        </p>-->
<!--        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>-->
        <el-card style="width: 100%;margin-bottom: 20px;height: auto;float: left;margin-right: 15px" class="bank"
                 bodyStyle="padding:10px" shadow="hover" v-for="item in banks.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                 :key="item.id">
<!--          <div class="cover" @click="editBook(item)">-->
<!--          </div>-->
          <div class="info">
            <div class="title">
              {{item.title}}
            </div>
<!--            <i class="el-icon-delete" @click="deleteBook(item.id)"></i>-->
          </div>
          <div class="author">{{item.answer}}</div>
        </el-card>
<!--      </el-tooltip>-->
<!--      <edit-form @onSubmit="loadBanks()" ref="edit"></edit-form>-->
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="banks.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
import SearchBar from './SearchBar'
export default {
  name: 'Bank',
  components: {SearchBar},
  data () {
    return {
      banks: [
        {
          id: '1',
          title: 'Java有哪些数据类型?',
          answer: '基本数据类型:数值型(整数类型(byte,short,int,long),浮点类型(float,double)),字符型(char),布尔型(boolean);' +
            '引用数据类型:' +
            '类(class)' +
            '接口(interface)' +
            '数组([])',
          category: {
            id: '1',
            name: 'JavaSE'
          }
        }
      ],
      currentPage: 1,
      pagesize: 6
    }
  },
  mounted: function () {
    this.loadBanks()
  },
  methods: {
    loadBanks () {
      var _this = this
      this.$axios.get('/banks').then(resp => {
        if (resp && resp.status === 200) {
          _this.banks = resp.data.result
        }
      })
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    searchResult () {
      var _this = this
      this.$axios
        .get('/search?keywords=' + this.$refs.searchBar.keywords, {
        }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
    },
    deleteBook (id) {
      this.$confirm('此操作将永久删除该书籍, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios
          .post('/delete', {id: id}).then(resp => {
            if (resp && resp.status === 200) {
              this.loadBooks()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
      // alert(id)
    },
    editBook (item) {
      this.$refs.edit.dialogFormVisible = true
      this.$refs.edit.form = {
        id: item.id,
        cover: item.cover,
        title: item.title,
        author: item.author,
        date: item.date,
        press: item.press,
        abs: item.abs,
        category: {
          id: item.category.id.toString(),
          name: item.category.name
        }
      }
    }
  }
}
</script>

<style scoped>
  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 24px;
    text-align: left;
  }

  .author {
    color: #333;
    width: auto;
    font-size: 18px;
    margin-bottom: 6px;
    text-align: left;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }
</style>
