<template>
  <div class="board-app">
    <h1>📌 게시판 목록 v4 (Vue Component 분리)</h1>

    <PostForm @add-post="addPost" />

    <PostList
      :posts="sortedPosts"
      :selected-no="selectedNo"
      :edit-no="editNo"
      :edit-title="editTitle"
      :edit-content="editContent"
      @toggle-post="togglePost"
      @close-post="closePost"
      @start-edit="startEdit"
      @save-edit="saveEdit"
      @cancel-edit="cancelEdit"
      @delete-post="deletePost"
      @update:edit-title="editTitle = $event"
      @update:edit-content="editContent = $event"
    />
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import PostForm from './components/PostForm.vue';
import PostList from './components/PostList.vue';

const posts = ref([
  {
    no: 1,
    title: 'Vue.js 기초 배우기',
    content:
      'Vue.js는 사용자 인터페이스를 구축하기 위한 프로그레시브 프레임워크입니다.',
  },
  {
    no: 2,
    title: '자바스크립트 ES6 문법',
    content:
      'ES6는 JavaScript의 최신 문법을 포함하며, let/const, 화살표 함수, 구조 분해 할당 등을 제공합니다.',
  },
  {
    no: 3,
    title: 'Node.js와 Express',
    content:
      'Node.js는 서버 측에서 JavaScript를 실행할 수 있도록 하는 런타임이며, Express는 이를 위한 경량 웹 프레임워크입니다.',
  },
  {
    no: 4,
    title: 'MongoDB 기본 개념',
    content:
      'MongoDB는 NoSQL 데이터베이스로 JSON과 유사한 문서 기반 데이터를 저장하고 관리할 수 있습니다.',
  },
  {
    no: 5,
    title: '프론트엔드와 백엔드의 차이',
    content:
      '프론트엔드는 사용자가 보는 부분을 개발하는 것이고, 백엔드는 서버와 데이터베이스를 관리하는 부분입니다.',
  },
  {
    no: 6,
    title: '비동기 프로그래밍',
    content:
      'JavaScript의 비동기 처리 방식에는 콜백, 프로미스, async/await가 있습니다.',
  },
  {
    no: 7,
    title: 'Vue Router 사용법',
    content:
      'Vue Router를 사용하면 Vue.js 애플리케이션에서 페이지 이동을 쉽게 처리할 수 있습니다.',
  },
  {
    no: 8,
    title: '컴포넌트 기반 개발',
    content:
      'Vue.js에서는 컴포넌트를 사용하여 UI를 작은 단위로 쪼개서 관리할 수 있습니다.',
  },
  {
    no: 9,
    title: 'CSS와 SCSS 차이점',
    content: 'SCSS는 CSS의 확장된 버전으로 변수, 중첩, 믹스인 등을 지원합니다.',
  },
  {
    no: 10,
    title: 'Git과 GitHub 사용법',
    content:
      'Git은 버전 관리 시스템이며, GitHub는 이를 활용한 원격 저장소 플랫폼입니다.',
  },
]);

const selectedNo = ref(null);

const editNo = ref(null);
const editTitle = ref('');
const editContent = ref('');

const sortedPosts = computed(() => {
  return [...posts.value].sort((a, b) => b.no - a.no);
});

const togglePost = (no) => {
  selectedNo.value = selectedNo.value === no ? null : no;

  if (selectedNo.value !== editNo.value) {
    editNo.value = null;
    editTitle.value = '';
    editContent.value = '';
  }
};

const closePost = () => {
  selectedNo.value = null;
  editNo.value = null;
  editTitle.value = '';
  editContent.value = '';
};

const addPost = ({ title, content }) => {
  if (!title.trim() || !content.trim()) {
    alert('제목과 내용을 입력하세요.');
    return;
  }

  const maxNo =
    posts.value.length > 0
      ? Math.max(...posts.value.map((post) => post.no))
      : 0;

  const newPost = {
    no: maxNo + 1,
    title,
    content,
  };

  posts.value.push(newPost);
  selectedNo.value = newPost.no;
  editNo.value = null;
};

const startEdit = (post) => {
  editNo.value = post.no;
  editTitle.value = post.title;
  editContent.value = post.content;
};

const saveEdit = (no) => {
  if (!editTitle.value.trim() || !editContent.value.trim()) {
    alert('제목과 내용을 입력하세요.');
    return;
  }

  const targetPost = posts.value.find((post) => post.no === no);

  if (targetPost) {
    targetPost.title = editTitle.value;
    targetPost.content = editContent.value;
  }

  editNo.value = null;
  editTitle.value = '';
  editContent.value = '';
};

const cancelEdit = () => {
  editNo.value = null;
  editTitle.value = '';
  editContent.value = '';
};

const deletePost = (no) => {
  const result = confirm('해당 글을 삭제하시겠습니까?');
  if (!result) return;

  posts.value = posts.value.filter((post) => post.no !== no);

  if (selectedNo.value === no) {
    selectedNo.value = null;
  }

  if (editNo.value === no) {
    editNo.value = null;
    editTitle.value = '';
    editContent.value = '';
  }
};
</script>
