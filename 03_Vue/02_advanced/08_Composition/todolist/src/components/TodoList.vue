<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoItem in todolist"
          :key="todoItem.id"
          :todoItem="todoItem"
          @toggle="$emit('toggle', $event)"
          @delete="$emit('delete', $event)"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import TodoListItem from './TodoListItem.vue';

const props = defineProps({
  todolist: { type: Array, required: true },
});

const emit = defineEmits(['delete', 'toggles']);
</script>
