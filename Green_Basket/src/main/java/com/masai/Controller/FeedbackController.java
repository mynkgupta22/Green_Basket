package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.FeedbackException;
import com.masai.Model.Feedback;
import com.masai.Services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService fdbkService;
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback fdbk)  {
		Feedback feedback=fdbkService.addFeedback(fdbk);
		
		return new ResponseEntity<>(feedback,HttpStatus.CREATED);
	}

	@GetMapping("/feedback/{vegId}")
	public ResponseEntity<List<Feedback>> viewAllFeedback(@PathVariable("vegId") Integer vegId) {
           List<Feedback> list=fdbkService.viewAllFeedback(vegId);
		
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}

	@GetMapping("/getFeedback/{customerId}")
	public ResponseEntity<List<Feedback>> viewFeedback(@PathVariable("customerId") Integer customerId) {
        List<Feedback> list=fdbkService.viewFeedback(customerId);
		
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}

}
