# cloud-demo
微服务demo程序，部署在k8s上

目录结构
cloud-demo-deploy-file:部署文件
cloud-demo:前端
cloud-eureka:eureka注册中心
cloud-first-service:第一个服务
cloud-second-service:第二个服务
cloud-zuul:网关

微服务不用说了，大家都知道，就是可以将pom包都放在最外层的pom下，方便管理版本，然后是为了后面方便演示k8s的升级策略，将第一个服务和第二个服务都做了两个版本

容器和k8s
相关信息都可以百度学习到，不怎么形象的说容器可以看成一个虚拟机，k8s就是管理容器的

安装k8s集群：https://www.kubernetes.org.cn/5904.html
在自己本地VMware虚拟机上安装的话，考虑自己机器实际情况来分节点，我是分了4个虚拟机4个节点安装，一个master节点，三个node节点，节点网络必须是通的！！！

镜像
做镜像的文件都写在dockerFile文件里了，如果需要打印日志等其他参数，可以修改dockerFile文件即可，镜像做好之后一定要使用docker run一下试试，不要直接到k8s中调错，费时间
其中ng镜像使用官方的就OK了，不用自己做

k8s运行服务
命令：kubectl apply -f XXX.yaml
比如运行eureka：kubectl apply -f cloud-eureka-1.0.yaml，报错根据提示解决，记住一点，k8s是高可用的（kill 没用），如果需要干掉程序，使用命令：kubectl delete -f cloud-eureka-1.0.yaml

yaml文件解释
yaml可以百度到是什么意思，这里简单解释一下，以cloud-eureka-1.0.yaml为例：
首先是命名空间，是为了区别其他应用的，也可不用，建议使用，如果不用，后面所有的yaml中namespace都要去掉
然后是配置文件：目前配置文件是使用configmap做的，使用configmap的话，配置文件中不要有注释，否则报错；如嫌麻烦，可直接使用hostpath挂载文件即可，或者使用后面的nfs文件系统进行挂载
接下来是服务控制器：这个可参考百度即可，如果挂载文件方式改变，改变yaml即可
最后就是service:这个十分重要，如果没有这个，你的服务根本不能暴露出来，（第一个服务和第二个服务就没有service）具体的详情网络，可以自行百度

前端
前端是使用ng部署的页面，将nginx.conf和前端页面使用nfs网络文件的方式印射到容器内部的，也可自行尝试pv和pvc操作




