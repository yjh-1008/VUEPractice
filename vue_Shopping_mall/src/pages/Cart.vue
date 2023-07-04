<template>
    <div class="cart">
      <div class="container">
        <ul>
          <li v-for="(i, idx) in state.itmes" :key="idx">
            <img :src="require(i.imgPath)"/>
            <span class="name">{{ i.name }}</span>
            <span class="price">{{ i.price }}</span>
          </li>
        </ul>
      </div>

    </div>

</template>

<script>
import axios from 'axios'
import {reactive} from 'vue'
export default {
  name: "Cart",
  setup() {
    const state = reactive( {
      items: [],
    })

    axios.get("/api/cart/items").then(({data}) => {
      state.items = data;
    })
    return {state};
  }
  
};
</script>

<style>
</style>
