<!--门户页面-->
<template>
  <div>
    <home-index class="home-index"
    v-bind:menulist="data.datalist"></home-index>
    <router-view/>
  </div>
</template>

<script>
import HomeIndex from '@/components/home/HomeIndex'
export default {
  name: 'Home',
  components: {HomeIndex},
  data () {
    return {
      'code': -999,
      'message': '',
      'data': {}
    }
  },
  mounted () {
    this.$nextTick(() => {
      this.initHome()
    })
  },
  methods: {
    initHome () {
      this.$axios('/admin/roles/menus').then(function (response) {
        console.log(response.data)
        this.data = response.data
      }).catch(failResponse => {})
    }
  }
}
</script>

<style scoped>

</style>
