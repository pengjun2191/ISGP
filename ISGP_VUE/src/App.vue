<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>
import HomeIndex from '@/components/home/HomeIndex'
export default {
  name: 'App',
  components: {HomeIndex}
}
</script>

<style>
@import "../static/css/allcss.css";
#app{
  margin-top: 0px;
}
</style>
