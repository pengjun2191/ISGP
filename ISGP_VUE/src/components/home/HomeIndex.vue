<!--首页门户-->
<template>
<div>
  <i-s-g-p-header></i-s-g-p-header>
  <navigation v-for="item in menulist"
              v-bind:menuLinks="item"
  v-bind:key="item.menuId"></navigation>
  <i-s-g-p-footer></i-s-g-p-footer>
</div>
</template>

<script>
import ISGPFooter from '@/components/common/ISGPFooter'
import ISGPHeader from '@/components/common/ISGPHeader'
import Navigation from './Navigation'
export default {
  name: 'HomeIndex',
  props: ['menulist'],
  components: {ISGPFooter, ISGPHeader, Navigation}
}
</script>

<style scoped>

</style>
