package com.example.spring_project_altynay.controller;

import com.example.spring_project_altynay.db.Task;
import com.example.spring_project_altynay.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Home {
    @Autowired
    private TaskService taskService;

 @GetMapping(value = "/")
    public String index(Model model)
 {
     List<Task>allTask=taskService.tasks();
     model.addAttribute("tasks",allTask);
     return "index";
 }
 @GetMapping(value = "/add")
 public String addPage(){
     return "add";
 }

 @PostMapping (value = "/addPost")
    public String add(@RequestParam(name = "task_name") String name,
                      @RequestParam(name="task_description") String description,
                      @RequestParam(name="date") String date,
                      @RequestParam(name="completion") String completion

 ){
     Task task=new Task();
     task.setName(name);
     task.setDescription(description);
     task.setDate(date);
     task.setCompletion(completion);

     taskService.addTask(task);
     return "redirect:/";
 }
 @GetMapping(value = "/details/{taskId}")
    public String details(Model model,@PathVariable(name="taskId") Long id){
      Task task=taskService.getTask(id);

      model.addAttribute("task",task);
      return "details";

 }
 @GetMapping(value = "/edit/{taskId}")
    public String edit(Model model,@PathVariable(name="taskId") Long id)
 {

     Task task=taskService.getTask(id);

     model.addAttribute("task",task);
    return "edit";
 }
 @PostMapping(value="/post_edit")
    public String editTask(@RequestParam(name = "taskId") Long id,
                           @RequestParam(name = "task_name") String name,
                           @RequestParam(name="task_description") String description,
                            @RequestParam(name = "date") String date,
                       @RequestParam(name = "completion") String completion)
 {
  Task task=taskService.getTask(id);
     if (task != null) {
         task.setName(name);
         task.setDescription(description);
         task.setCompletion(completion);
         task.setDate(date);
//
         taskService.update(task);
         return "redirect:/details/"+id;
     }
     else
         return "redirect:/";
 }
 @PostMapping(value = "/delete")
 public String deleteTask(@RequestParam(name = "id") Long id)
 {
    Task task=taskService.getTask(id);
    taskService.deleteTask(task);
    return "redirect:/";
 }



}
