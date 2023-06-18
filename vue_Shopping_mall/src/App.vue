<template>
  <Header/>
  <RouterView/>
  <Footer/>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import store from './scripts/store';
import axios from 'axios';
import { useRoute } from 'vue-router';
import { watch } from 'vue';
export default {
  name: 'App',
  components: {Header, Footer},
  setup() {
    const check = ()=> {
      axios.get("/api/account/check").then(({data})=> {
        console.log(data);


        if(data) {
          store.commit("setAccount",data);
        }else {
          store.commit("setAccount",data);
        }
      })
    } 

    const route = useRoute();

    watch(route,()=> {
      check();
    })
    
  },
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
