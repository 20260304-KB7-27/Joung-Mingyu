<template>
  <li class="post-wrap">
    <div class="post-item" @click="emit('toggle-post', post.no)">
      <span>{{ post.no }}. {{ post.title }}</span>
      <span class="arrow">{{ selectedNo === post.no ? '▲' : '▼' }}</span>
    </div>

    <div class="post-content" v-if="selectedNo === post.no">
      <PostEditor
        v-if="editNo === post.no"
        :edit-title="editTitle"
        :edit-content="editContent"
        @update:edit-title="emit('update:edit-title', $event)"
        @update:edit-content="emit('update:edit-content', $event)"
        @save="emit('save-edit', post.no)"
        @cancel="emit('cancel-edit')"
      />

      <div v-else>
        <h3>{{ post.title }}</h3>
        <p>{{ post.content }}</p>
        <button @click="emit('start-edit', post)">수정</button>
        <button @click="emit('delete-post', post.no)">삭제</button>
        <button @click="emit('close-post')">닫기</button>
      </div>
    </div>
  </li>
</template>

<script setup>
import PostEditor from './PostEditor.vue';

defineProps({
  post: Object,
  selectedNo: Number,
  editNo: Number,
  editTitle: String,
  editContent: String,
});

const emit = defineEmits([
  'toggle-post',
  'close-post',
  'start-edit',
  'save-edit',
  'cancel-edit',
  'delete-post',
  'update:edit-title',
  'update:edit-content',
]);
</script>
