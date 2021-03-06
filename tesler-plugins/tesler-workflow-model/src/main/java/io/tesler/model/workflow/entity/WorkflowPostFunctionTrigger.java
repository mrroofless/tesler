/*-
 * #%L
 * IO Tesler - Workflow Model
 * %%
 * Copyright (C) 2018 - 2019 Tesler Contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package io.tesler.model.workflow.entity;

import io.tesler.model.core.entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * Выполняемые переходы при получении ответа от смежных систем
 */
@Getter
@Setter
@Entity
@Table(name = "WF_POST_FUN_TRIGGER", uniqueConstraints = @UniqueConstraint(columnNames = {"REQ_POST_FUN_ID",
		"RESP_WAIT_STEP_ID"}))
public class WorkflowPostFunctionTrigger extends BaseEntity {

	/**
	 * Действие при котором осуществляется вызов смежной системы
	 */
	@ManyToOne
	@JoinColumn(name = "REQ_POST_FUN_ID", nullable = false)
	private WorkflowPostFunction requestPostFunction;

	/**
	 * Шаг в котором разрешается обработать ответ смежной системы
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_WAIT_STEP_ID")
	private WorkflowStep responseWaitStep;

	/**
	 * Выполняемый переход при ответе с кодом 1
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_CODE_1_TRANSITION_ID")
	private WorkflowTransition responseCode1Transition;

	/**
	 * Выполняемый переход при ответе с кодом 2
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_CODE_2_TRANSITION_ID")
	private WorkflowTransition responseCode2Transition;

	/**
	 * Выполняемый переход при ответе с кодом 3
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_CODE_3_TRANSITION_ID")
	private WorkflowTransition responseCode3Transition;

	/**
	 * Выполняемый переход при ответе с кодом 4
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_CODE_4_TRANSITION_ID")
	private WorkflowTransition responseCode4Transition;

	/**
	 * Выполняемый переход при ответе с кодом 5
	 */
	@ManyToOne
	@JoinColumn(name = "RESP_CODE_5_TRANSITION_ID")
	private WorkflowTransition responseCode5Transition;

}
