const fs = require('fs');
const path = require('path');
const folderPath = path.join(__dirname, '/test');

console.log('폴더 경로: ', folderPath);

if (fs.existsSync(folderPath)) {
  console.log('폴더가 존재합니다!');
} else {
  fs.mkdir(folderPath, (err) => {
    if (err) {
      console.error(err);
      return;
    }
    console.log('폴더가 생성되었습니다.');
  });
}
