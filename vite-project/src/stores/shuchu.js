import fs from 'fs/promises';
import https from 'https';

// 替换为你的 JSON API 地址
const apiUrl = 'https://geo.datav.aliyun.com/areas_v3/bound/100000_full.json';

https.get(apiUrl, (response) => {
  let data = '';

  response.on('data', (chunk) => {
    data += chunk;
  });

  response.on('end', async () => {
    try {
      const jsonData = JSON.parse(data);
      const jsonString = JSON.stringify(jsonData, null, 2);
      await fs.writeFile('china.json', jsonString);
      console.log('File saved successfully');
    } catch (error) {
      console.error('Error parsing JSON:', error);
    }
  });
}).on("error", (err) => {
  console.error("Error: " + err.message);
});
