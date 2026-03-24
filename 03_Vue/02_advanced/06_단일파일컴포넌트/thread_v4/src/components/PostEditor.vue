<template>
  <div>
    <input
      type="text"
      :value="editTitle"
      @input="$emit('update:edit-title', $event.target.value)"
      placeholder="제목 수정하기"
      class="input-box"
    />
    <textarea
      :value="editContent"
      @input="$emit('update:edit-content', $event.target.value)"
      placeholder="내용 수정하기"
      class="input-box"
    ></textarea>
    <button @click="$emit('save')">저장</button>
    <button @click="$emit('cancel')">취소</button>
  </div>
</template>

<script setup>
defineProps({
  editTitle: String,
  editContent: String,
});

defineEmits(['update:edit-title', 'update:edit-content', 'save', 'cancel']);
</script>
