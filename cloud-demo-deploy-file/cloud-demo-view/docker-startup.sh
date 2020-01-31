docker run --name nginx -p 10086:10086 -v /root/cloud-demo/cloud-demo-view/nginx.conf:/etc/nginx/nginx.conf -v /root/cloud-demo/cloud-demo-view/cloud-demo:/cloud-demo-view -d nginx

