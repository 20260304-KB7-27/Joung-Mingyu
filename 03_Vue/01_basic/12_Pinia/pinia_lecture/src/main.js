import { createApp } from 'vue';
import { createPinia } from 'pinia';
import App from './App.vue';
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate';

const app = createApp(App);

// persistedstate 추가한 pinia
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

// Pinia 추가
app.use(pinia);

app.mount('#app');
