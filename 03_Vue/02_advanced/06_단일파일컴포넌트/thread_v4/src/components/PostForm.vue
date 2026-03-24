<template>
  <div class="write-box">
    <input
      v-model="title"
      type="text"
      placeholder="제목을 작성하세요."
      class="input-box"
    />
    <input
      v-model="content"
      placeholder="내용을 작성하세요."
      class="input-box"
    ></input>
    <button @click="handleAdd">등록</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const emit = defineEmits(['add-post']);

const title = ref('');
const content = ref('');

const handleAdd = () => {
  emit('add-post', {
    title: title.value,
    content: content.value,
  });

  title.value = '';
  content.value = '';
};
</script>
