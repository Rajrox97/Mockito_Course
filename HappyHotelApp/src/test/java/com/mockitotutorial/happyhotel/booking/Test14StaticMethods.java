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
class Test14StaticMethods {
	
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
	void should_CalculateCorrectPrice() {
		try(MockedStatic<CurrencyConverter> mockedConverter = mockStatic(CurrencyConverter.class)){
			//given 
			BookingRequest	bookingRequest = new BookingRequest("1", LocalDate.of(2021,01,01),
					LocalDate.of(2021,01,05), 2, false);
			double expected = 400.0;
			mockedConverter.when(()->CurrencyConverter.toEuro(anyDouble())).thenReturn(400.0);
			
			//when
			double actual = bookingService.calculatePriceEuro(bookingRequest);
			
			//then
			assertEquals(expected,actual);
		}
		

		
	}

}
