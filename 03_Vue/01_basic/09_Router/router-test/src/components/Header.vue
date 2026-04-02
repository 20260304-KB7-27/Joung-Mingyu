<template>
  <div>
    <!-- 
      RouterLink
      - 클릭하면 페이지 이동
      - to 속성에 이동할 경로 지정
    -->
    <RouterLink to="/">Home</RouterLink> |
    <RouterLink to="/members">Members</RouterLink> |
    <RouterLink :to="{ name: 'members-nested' }">Members-nested</RouterLink>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';
</script>

<style scoped></style>
