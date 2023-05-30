<template>
    <div class="Home">
        <main>
    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">Album example</h1>
          <p class="lead text-body-secondary">
            Something short and leading about the collection below—its contents,
            the creator, etc. Make it short and sweet, but not too short so
            folks don’t simply skip over it entirely.
          </p>
          <p>
            <a href="#" class="btn btn-primary my-2">Main call to action</a>
            <a href="#" class="btn btn-secondary my-2">Secondary action</a>
          </p>
        </div>
      </div>
    </section>

    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(item,idx) in state.items" :key="idx">
            <Card/>
          </div>
        </div>
      </div>
    </div>
  </main>
    </div>

</template>

<script>
import axios from 'axios'
import Card from '@/components/Card.vue'
import {reactive} from 'vue'
export default {
  name: "Home",
  components: {Card},
  setup() {
    const state = reactive({
      items:[],
    })
    axios.get('/api/items').then((res)=> {
      state.items = res.data
    })
    return state
  }
};
</script>

<style>
</style>
