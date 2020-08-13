<!--
 * @FileDescription 主页
 * @Author livre
 -->
<template>
  <div>
    <!--  使用components中的NavMenu组件  -->
    <nav-menu></nav-menu>
    <router-view/>
  </div>
</template>

<script>
import NavMenu from './common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style scoped>

</style>
