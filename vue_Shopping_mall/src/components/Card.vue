<template>
                <div class="card shadow-sm">
                  <span class="img" :style="{backgroundImage: `url(${item.imgPath})})`}">
                    <img :src="item.imgPath+'.jpeg'" :alt="item.name" />
                  </span>
            
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c" />
                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
              <div class="card-body">
                <p class="card-text">
                  {{item.name}}
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <button class="btn btn-primary">구입하기</button>
                  <small class="text-body-secondary">{{item.price}}원</small>
                </div>
              </div>
            </div>
</template>

<script>
    export default {
        name: 'Card',
        props:{
            item:Object,
        },
        mounted() {
          console.log(this.$props.item)
        }
    }
</script>

<style scoped>
.card .img{
 width:100%;
 height: 250px;
 display: inline;
 background-size: cover;
 background-position: center;
}
</style>