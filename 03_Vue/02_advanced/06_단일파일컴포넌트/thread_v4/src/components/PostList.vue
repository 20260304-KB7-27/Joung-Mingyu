<template>
  <ul>
    <PostItem
      v-for="post in posts"
      :key="post.no"
      :post="post"
      :selected-no="selectedNo"
      :edit-no="editNo"
      :edit-title="editTitle"
      :edit-content="editContent"
      @toggle-post="$emit('toggle-post', $event)"
      @close-post="$emit('close-post')"
      @start-edit="$emit('start-edit', $event)"
      @save-edit="$emit('save-edit', $event)"
      @cancel-edit="$emit('cancel-edit')"
      @delete-post="$emit('delete-post', $event)"
      @update:edit-title="$emit('update:edit-title', $event)"
      @update:edit-content="$emit('update:edit-content', $event)"
    />
  </ul>
</template>

<script setup>
import PostItem from './PostItem.vue';

defineProps({
  posts: Array,
  selectedNo: Number,
  editNo: Number,
  editTitle: String,
  editContent: String,
});

defineEmits([
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
