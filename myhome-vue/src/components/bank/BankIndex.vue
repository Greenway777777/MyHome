<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu></SideMenu>
    </el-aside>
    <el-main>
      <bank class="books-area"></bank>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Bank from './Bank'
export default {
  name: 'BankIndex',
  components: {SideMenu, Bank}
}
</script>

<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
