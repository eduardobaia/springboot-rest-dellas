package com.dellas.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.TaskConverter;
import com.dellas.app.dto.TaskDTO;
import com.dellas.app.exception.MultipleTaskException;
import com.dellas.app.exception.TaskException;
import com.dellas.app.model.Task;
import com.dellas.app.repository.TaskRepository;
import com.dellas.app.service.TaskService;

@Transactional(readOnly = true)
@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;

	private static final String NOME_OBRIGATORIO = "O Nome é obrigatório.";
	private static final String lOCK_OPTIMISTIC = "Entidade desatualizada, favor atualizar a página para concluir alteração.";

	@Override
	public List<TaskDTO> findByFilter(final TaskDTO taskDTO) {
		return TaskConverter.toListDTO(taskRepository.findByNameOrId(taskDTO.getName(), taskDTO.getId()));
	}

	@Override
	public List<TaskDTO> findAll() {
		return TaskConverter.toListDTO((List<Task>) taskRepository.findAll());
	}

	@Override
	public TaskDTO findById(final Long id) {
		return TaskConverter.toDTO(taskRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public TaskDTO update(final TaskDTO taskDTO) {
		TaskConverter.toModel(taskDTO).setLastUpdateTime(new Date());
		checkException(validateUpdateTask(taskDTO));
		return TaskConverter.toDTO(taskRepository.save(TaskConverter.toModel(taskDTO)));
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final Long id) {
		taskRepository.delete(id);
	}

	@Transactional(readOnly = false)
	@Override
	public TaskDTO persist(final TaskDTO taskDTO) {
		checkException(validatePersistTask(taskDTO));
		return TaskConverter.toDTO(taskRepository.save(TaskConverter.toModel(taskDTO)));
	}

	private void checkException(final ArrayList<TaskException> exceptions) {
		if (!exceptions.isEmpty()) {
			throw new MultipleTaskException(exceptions);
		}
	}

	private ArrayList<TaskException> validatePersistTask(final TaskDTO taskDTO) {
		final ArrayList<TaskException> errors = new ArrayList<TaskException>();
		validateName(taskDTO, errors);
		return errors;
	}

	private ArrayList<TaskException> validateUpdateTask(final TaskDTO taskDTO) {
		final ArrayList<TaskException> errors = new ArrayList<TaskException>();
		validateName(taskDTO, errors);
		validateLockOptimistic(taskDTO, errors);
		return errors;
	}

	private void validateName(final TaskDTO taskDTO, final ArrayList<TaskException> errors) {
		if (StringUtils.isBlank(taskDTO.getName())) {
			errors.add(new TaskException(NOME_OBRIGATORIO));
		}
	}

	private void validateLockOptimistic(final TaskDTO task, final ArrayList<TaskException> errors) {
		if (!taskRepository.findOne(task.getId()).getVersion().equals(task.getVersion()) ) {
			errors.add(new TaskException(lOCK_OPTIMISTIC));
		}
	}
}
