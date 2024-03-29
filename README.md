# cloud-native-todolist

## Project Purpose
 Todo List project is to create a simple web-based application that allows users to create and manage a list of tasks or to-do items. Users can check all tasks they added to the list, including deleted ones.

## Contributors
 Xinyi Xu
 
## Languages and Frameworks:
 1. Java
 2. Spring Boot
 3. Docker
 4. Kubernetes

## Todo List Architecture

 ![todolist structure]([todolist structure.png](https://github.com/cicixinyi/cloud-native-todolist/blob/main/todolist%20structure.png))

## Run the app in Kubernetes
To run the app in Kubernetes, install Docker for Desktop Mac or Windows or choose GCP Kubernetes cluster. Each folder has one yaml file for the app. Below are the steps for running the app in platforms:
 1. First clone the project to GCP kubernetes cluster or local machine
```
    git clone https://github.com/cicixinyi/cloud-native-todolist.git
```
 2. Compile and run both yaml files directly. Do not change directory with the following command:
```
    kubectl apply -f todolist/todolist.yaml 
    kubectl apply -f history/history.yaml 
```
 3. Check and watch if all the components are up and running
```
    kubectl get all
```
## Testing the App on Local Machine
Once all the services have been deployed, you can test the Todo List features as follows:
1. To look at and edit the todo list. In your browser's address bar, enter the following:

   http://localhost:6080/todo
  
2. View the history of the todo list. In your browser's address bar, enter the following:

   http://localhost:6081/history
  
## Testing the App on GKE
Once all the services have been deployed on the GKE cluster, you can test the Todo List features as follows:
1. Find the external IP address of one of your nodes:
```
  kubectl get nodes -o wide

```

2. To look at and edit the todo list. In your browser's address bar, enter the following:

   <EXTERNAL_IP>:6080/todo

3. View Flights from the database. In your browser's address bar, enter the following:
   
   <EXTERNAL_IP>:6081/history
   
## Edit Tasks in Todo List  
1. To add tasks to the list. Enter the following in terminal:
```
    curl -X POST -H "Content-Type: application/json" -d '{"title":"Your task name"}' http://localhost:6080/todo
```

2. To delete a task. Remember the task's id number and enter the following in terminal:
```
    curl -X DELETE http://localhost:6080/todo/id
```

3. To update status when the task finished. Remember the task's id number and enter the following in terminal:
```
    curl -X PUT http://localhost:6080/todo/id
```

## Existing Problem:
In the history application, there is a call attempt to the todo microservice with [String url='http://localhost:6080/todo/']. This will not work on K8s. So the communication to history does not work. Did not get to using environment variables with a ConfigMap.
