package groom.streaming.chat.service;

import groom.streaming.chat.domain.Chat;
import groom.streaming.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional
    public void postChat(String msg) {
        Chat chat = Chat.builder()
                .message(msg)
                .build();

        chatRepository.save(chat);
    }

    @Transactional
    public List<Chat> getChats() {
        return chatRepository.findAll();
    }
}
