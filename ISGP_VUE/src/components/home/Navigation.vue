<template>
  <el-container>
  <el-aside width="200px">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>{{menuLinks.menuNameZH}}}</span>
        </template>
        <el-menu-item-group v-for="menuFirstChild in menuLinks.children"
        v-bind:key="menuFirstChild.menuId"
                            @open="handleOpen"
                            @close="handleClose">
          <template slot="title">
            <span>{{menuFirstChild.menuNameZH}}</span>
          </template>
          <el-menu-item v-for="menuSecondChild in menuFirstChild.children"
                        v-bind:key="menuSecondChild.menuId"><span>{{menuSecondChild.menuNameZH}}</span></el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
    <el-main v-model='showStatus' v-for ="menuFirst in menuLinks.children"
             v-bind:key="menuFirst.menuId" >
      <span v-for ="menuSecond in menuFirst.children" :key="menuSecond.menuID">&nbsp;&nbsp;
      <el-link href="login" target="_blank" >{{menuSecond.menuNameES}}</el-link></span>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'Navigation',
  props: ['menuLinks'],
  data () {
    return {
      showStatus: false
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
      this.showStatus = true
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
      this.showStatus = false
    }

  }
}
</script>

<style scoped>

</style>
