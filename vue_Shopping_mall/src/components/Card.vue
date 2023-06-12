<template>
                <div class="card shadow-sm">
                  <span class="picture" :style="{'background-image': `url(${item.imgPath}')}`}">
               
                  </span>
            
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c" />
                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
              <div class="card-body">
                <p class="card-text">
                  {{item.name}} &nbsp;
                  <span class="discount  badge bg-danger">{{item.discount}}%</span>
                </p>
                
                <div class="d-flex justify-content-between align-items-center">
                  <button class="btn btn-primary">구입하기</button>
                  <span class="price text-body-secondary">{{lib.getNumerFormatted(item.price)}}원</span>
                 
                  <span class="real text-danger text-body-secondary">{{lib.getNumerFormatted(item.price -(item.price*item.discount/100))}}원</span>
                </div>
              </div>
            </div>
</template>

<script>
  import lib from '@/scripts/lib';
    export default {
        name: 'Card',
        props:{
            item:Object,
        },
        setup(){
          return {lib}
        },
        mounted() {
          console.log(this.$props.item)
        }
    }
</script>

<style scoped>
.card .picture{
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