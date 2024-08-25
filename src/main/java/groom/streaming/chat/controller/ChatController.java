package groom.streaming.chat.controller;

import groom.streaming.chat.domain.Chat;
import groom.streaming.chat.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // Request - Response
    @GetMapping("/chat")
    public String getChatMessages(Model model) {
        List<Chat> chats = chatService.getChats();
        model.addAttribute("chats", chats);
        return "chat";
    }

    @PostMapping("/chat")
    public String postChatMessage(@RequestParam("msg") String msg) {
        chatService.postChat(msg);
        return "redirect:/chat";
    }
}
