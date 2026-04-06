<template>
  <button @click="increment">좋아요 누르기</button>
</template>

<script setup>
import { useLikePersistStore } from '@/stores/persist/persist_like';

// import { useLikeStore } from '@/stores/like';

const { increment } = useLikePersistStore();
</script>

<style scoped></style>
