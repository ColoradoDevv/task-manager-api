package com.coloradodev.task_manager_api.service;

import com.coloradodev.task_manager_api.dto.TaskDTO;
import com.coloradodev.task_manager_api.entity.Task;
import com.coloradodev.task_manager_api.entity.User;
import com.coloradodev.task_manager_api.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO taskDTO, User user) {
        Task task = Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .user(user)
                .build();
        Task savedTask = taskRepository.save(task);
        return mapToDTO(savedTask);
    }

    public List<TaskDTO> getAllTasks(User user) {
        return taskRepository.findByUserId(user.getId()).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id, User user) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        if (!task.getUser().getId().equals(user.getId())) {
            throw new EntityNotFoundException("Task not found"); // Security: don't reveal it exists
        }
        return mapToDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO, User user) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        if (!task.getUser().getId().equals(user.getId())) {
            throw new EntityNotFoundException("Task not found");
        }

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());

        Task updatedTask = taskRepository.save(task);
        return mapToDTO(updatedTask);
    }

    public void deleteTask(Long id, User user) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        if (!task.getUser().getId().equals(user.getId())) {
            throw new EntityNotFoundException("Task not found");
        }
        taskRepository.delete(task);
    }

    private TaskDTO mapToDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .build();
    }
}
