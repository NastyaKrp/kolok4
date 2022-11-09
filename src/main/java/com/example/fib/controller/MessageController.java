package com.example.fib.controller;

import org.springframework.web.bind.annotation.*;
import com.example.fib.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")


public class MessageController {
    private int counter = 10;
    private  int i = 0;
    private ArrayList<Integer> fib = new ArrayList<Integer>();

   /* private MessageController(int n)
    {
        fib.add(0);
        fib.add(1);
        this.counter = n;
    }*/

    public void Sol(int n)
    {
        for(int i = 0; i < n - 2; i++)
        {
            fib.add(fib.get(i) + fib.get(i + 1));
        }
        return;
    }

    private List<Map<String, Integer>> messages = new ArrayList<Map<String, Integer>>()
    {{
        fib.add(0);
        fib.add(1);
        Sol(counter);
        for(i = 0; i < counter; i++)
        {
            add(new HashMap<String, Integer>(){{put("id", i + 1); put("Number", fib.get(i)); }});
        }
    }};

    @GetMapping
    public List<Map<String, Integer>> list()
    {
        return messages;
    }




    /*@GetMapping("{id}")
    public Map<String, Integer> getOne(@PathVariable Integer id)
    {
        return getMessage(id);
    }

    private Map<String, Integer> getMessage(Integer id) {
        return messages.stream()
                .filter(message -> message.get(id).equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }*/

    /*@PostMapping
    public Map<String, Integer> create(@RequestBody Map<String, Integer> message)
    {
        message.put("id", counter++);
        messages.add(message);
        return message;
    }*/

    /*@PutMapping("{id}")
    public Map<String, Integer> update(@PathVariable String id, @RequestBody Map<String, Integer> message)
    {
        Map<String, Integer> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id", id);
        return messageFromDb;
    }*/

    /*@DeleteMapping("{id}")
    public void delete(@PathVariable String id)
    {
        Map<String, String> message = getMessage(id);
        messages.remove(message);
    }*/

}
