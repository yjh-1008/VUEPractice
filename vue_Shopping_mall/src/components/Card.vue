<template>
  <div class="card shadow-sm">
    <!-- <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}" >{{ item.imgPath }}</span> -->
    <!-- <span v-bind:style="{ backgroundImage: 'url(/src/assets' + item.imgPath+ '.jpeg)' }"></span> -->
    <img class="img" :src="require(`../assets${item.imgPath}.jpeg`)">
    <title>Placeholder</title>
    <rect width="100%" height="100%" fill="#55595c" />
    <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
    <div class="card-body">
      <p class="card-text">
        {{ item.name }} &nbsp;
        <span class="discount badge bg-danger">{{ item.discount }}%</span>
      </p>

      <div class="d-flex justify-content-between align-items-center">
        <button class="btn btn-primary" @click="addToCart(item.id)">
          <i class="fa fa-shopping-cart" aria-hidden="true"></i>
        </button>
        <span class="price text-body-secondary"
          >{{ lib.getNumerFormatted(item.price) }}원</span
        >

        <span class="real text-danger text-body-secondary"
          >{{
            lib.getNumerFormatted(
              item.price - (item.price * item.discount) / 100
            )
          }}원</span
        >
      </div>
    </div>
  </div>
</template>

<script>
import lib from "@/scripts/lib";
import axios from "axios";
export default {
  name: "Card",
  props: {
    item: Object,
  },
  setup() {
    const addToCart = (itemId) => {
      axios.post(`/api/cart/items/${itemId}`).then((res) => {
        console.log("success:", res);
      });
    };
    return { lib, addToCart };
  },
  mounted() {
    console.log(this.$props.item);
  },
};
</script>

<style scoped>
.card .img {
  width: 100%;
  height: 250px;
  display: inline-block;
  background-size: cover;
  background-position: center;
}

.card .card-body .price {
  text-decoration: line-through;
}
</style>
