<template>
  <Header/>
  <RouterView/>
  <Footer/>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import store from './scripts/store';
export default {
  name: 'App',
  components: {Header, Footer},
  setup() {
    const id = sessionStorage.getItem('id');
    if(id) {
      store.commit("setAccount",id)
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
