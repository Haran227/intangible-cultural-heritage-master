<template>
  <div class="main">
    <div ref="container"></div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader';
import { OrbitControls } from 'three/addons/controls/OrbitControls';

const container = ref<HTMLDivElement | null>(null);

onMounted(() => {
  if (container.value) {
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    const renderer = new THREE.WebGLRenderer();
    renderer.setSize(window.innerWidth, window.innerHeight);
    container.value.appendChild(renderer.domElement);

    // 添加光照
    const ambientLight = new THREE.AmbientLight(0xffffff, 0.5);
    scene.add(ambientLight);
    const directionalLight = new THREE.DirectionalLight(0xffffff, 0.5);
    directionalLight.position.set(0, 1, 1);
    scene.add(directionalLight);

    // 加载天空盒子纹理
    const cubeTextureLoader = new THREE.CubeTextureLoader();
    const skyboxTexture = cubeTextureLoader.load([
      '/models/skybox/right.jpg',
      '/models/skybox/left.jpg',
      '/models/skybox/top.jpg',
      '/models/skybox/bottom.jpg',
      '/models/skybox/front.jpg',
      '/models/skybox/back.jpg'
    ]);

    // 创建天空盒子材质
    const skyboxMaterial = new THREE.MeshBasicMaterial({
      envMap: skyboxTexture,
      side: THREE.BackSide
    });

    // 创建天空盒子
    const skybox = new THREE.Mesh(
      new THREE.BoxGeometry(1000, 1000, 1000),
      skyboxMaterial
    );
    scene.add(skybox);

    const loader = new GLTFLoader();
    loader.load('/models/scene.gltf', (gltf) => {
      const model = gltf.scene;
      scene.add(model);
      model.position.set(0, 0, 0);
      model.scale.set(1, 1, 1);
      camera.lookAt(model.position);
    }, undefined, (error) => {
      console.error('Error loading GLTF model:', error);
    });

    // 调整相机位置
    camera.position.set(2, 2, 5);

    const controls = new OrbitControls(camera, renderer.domElement);

    const animate = () => {
      requestAnimationFrame(animate);
      controls.update();
      renderer.render(scene, camera);
    };
    animate();
  }
});
</script>

<style scoped>
.main {
  width: 100%;
  height: 100vh;
  overflow: hidden;
}
</style>