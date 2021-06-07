package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class Test13StrictStubbing {
	
	@InjectMocks
	private BookingService bookingService;
	
	@Mock
	private PaymentService paymentServiceMock;
	@Mock
	private RoomService roomServiceMock;
	@Spy
	private BookingDAO bookingDAOMock;
	@Mock
	private MailSender mailSenderMock;
	@Captor
	private ArgumentCaptor<Double> doubleCaptor;
//	private ArgumentCaptor<BookingRequest> bookingRequestCaptor;


	
	@Test
	void should_InvokePayment_When_Prepaid() {
		//given 
		BookingRequest	bookingRequest = new BookingRequest("1", LocalDate.of(2021,01,01),
				LocalDate.of(2021,01,05), 2, false);
		lenient().when(paymentServiceMock.pay(any(),anyDouble())).thenReturn("1");
		
		//when
		bookingService.makeBooking(bookingRequest);
		
		//then
//		then(paymentServiceMock).should(times(1)).pay(bookingRequest,400.0);
//		verifyNoMoreInteractions(paymentServiceMock);
		//no exception is thrown. 
		
	}

}
