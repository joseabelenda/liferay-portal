package com.liferay.headless.delivery.internal.dto.v1_0.converter;


import com.liferay.headless.delivery.dto.v1_0.MessageBoardSuspiciousActivity;
import com.liferay.headless.delivery.dto.v1_0.MessageBoardSuspiciousActivityType;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.service.MBSuspiciousActivityTypeService;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "dto.class.name=com.liferay.message.boards.model.MBSuspiciousActivityType",
	service = {DTOConverter.class, MessageBoardSuspiciousActivityTypeDTOConverter.class}
)


public class MessageBoardSuspiciousActivityTypeDTOConverter implements
	DTOConverter<MBSuspiciousActivityType, MessageBoardSuspiciousActivityType>{


	@Override
	public MessageBoardSuspiciousActivityType toDTO(
		DTOConverterContext dtoConverterContext)
		throws Exception{

		MBSuspiciousActivityType mbSuspiciousActivityType =
			_mbSuspiciousActivityTypeService.getSuspiciousActivityType(
				(Long)dtoConverterContext.getId());


		return new MessageBoardSuspiciousActivityType(){

			{
				suspiciousTypeId = mbSuspiciousActivityType.getSuspiciousActivityTypeId();
				description	= mbSuspiciousActivityType.getDescription();

			}

		};
	}


	@Override
	public String getContentType() {

		return MessageBoardSuspiciousActivityType.class.getSimpleName();
	}

	@Reference
	private MBSuspiciousActivityTypeService _mbSuspiciousActivityTypeService;
}
