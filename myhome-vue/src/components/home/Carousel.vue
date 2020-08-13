<!--
 * @FileDescription 轮播卡片组件
 * @Author livre
 * @Date 2020年2月4日
 * @LastEditTime 2020年7月31日
 -->
<template>
  <el-card class="card-carousel">
  <el-carousel  class="push" :interval="4000" arrow="always">
    <el-carousel-item v-for="item in items" :key="item.id">
      <a :href=item.link target="_blank">
        <img :src=item.img alt="" class="carousel_img">
      </a>
      <h3>{{item.title}}</h3>
    </el-carousel-item>
  </el-carousel>
  </el-card>
</template>

<style>
  .el-carousel__item h3 {
    color: black;
    font-size: 15px;
    /*line-height: 300px;*/
    bottom: 43px;
    float: left;
    position: relative;
  }

  .card-carousel {
    /*margin: 0 auto;*/
    margin-left: 20px;
    width: 680px;
    height: 320px;
  }

  .push {
    /*margin-left: -15px;*/
  }

  .el-carousel__item:nth-child(2n) {
    background: black;
  }

  .el-carousel__item:nth-child(2n+1) {
    background: black;
  }

  .carousel_img {
    height: 100%;
    width: 100%;
    text-align: center;
  }
</style>

<script>
export default {
  name: 'Carousel',
  data: function () {
    return {
      /**
       * @description 轮播卡片的数据
       */
      items: [{
        id: 1,
        title: 'spring',
        img: '../../../static/img/spring.jpg',
        link: 'https://spring.io/'},
      {
        id: 2,
        title: 'java',
        img: '../../../static/img/java.jpg',
        link: 'https://www.oracle.com/java/'
      },
      {
        id: 3,
        title: 'mybatis',
        img: '../../../static/img/mybatis.jpg',
        link: 'https://mybatis.org/mybatis-3/'
      }]
    }
  }
}
</script>
