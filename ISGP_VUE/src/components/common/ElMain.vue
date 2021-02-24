<!--左侧管理菜单-->
<template>
  <el-main>
    <el-link href="https://element.eleme.io" target="_blank" v-if="menuChildLinks">{{menuChildLinks.menuNameES}}</el-link>
  </el-main>
</template>

<script>
export default {
  props: ['menuChildLinks'],
  name: 'ElMain'
}
</script>

<style scoped>

</style>
