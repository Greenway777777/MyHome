<template>
  <html >
  <body>
  <div id="win" v-on:click="tall">
    <span  style="font-size: 50px; color: #dd6161">gitter im chat room</span>
  </div>
  </body>
  </html>
<!--    <script>-->
<!--      ((window.gitter = {}).chat = {}).options = {-->
<!--        room: 'livreim/community',-->
<!--        activationElement: '.wel',-->
<!--      };//https://sidecar.gitter.im/dist/sidecar.v1.js-->
<!--    </script>-->
<!--  <script src="https://sidecar.gitter.im/dist/sidecar.v1.js" async defer></script>-->
</template>

<script>
export default {
  name: 'ChatIndex',
  methods: {
    tall () {
      (window.gitter = {}).chat = {}.options = {
        room: 'livreim/community',
        activationElement: '.win'
      }
    }
  }
}

</script>

<style scoped>
  #win{
    background-color: #3a8ee6;
    height: auto;
    width: auto;
    margin: 30px auto;
  }

</style>
