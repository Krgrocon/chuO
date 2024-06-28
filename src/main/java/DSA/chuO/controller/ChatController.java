//package DSA.chuO.controller;
//
//import DSA.chuO.model.ChatMessage;
//import DSA.chuO.service.ChatService;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import org.checkerframework.checker.units.qual.A;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import javax.annotation.PostConstruct;
//
//@Controller
//public class ChatController {
//    @Autowired
//    private ChatService chatService;
//
//
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//    @PostConstruct
//    public void init() {
//        chatService.addMessageListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                ChatMessage message = dataSnapshot.getValue(ChatMessage.class);
//                messagingTemplate.convertAndSend("/topic/chat", message);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
//                // 데이터가 변경될 때 수행할 작업을 여기에 작성하세요.
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                // 데이터가 삭제될 때 수행할 작업을 여기에 작성하세요.
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
//                // 데이터가 이동될 때 수행할 작업을 여기에 작성하세요.
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // 데이터 읽기가 취소될 때 수행할 작업을 여기에 작성하세요.
//            }
//        });
//    }
//
//    @MessageMapping("/chat")
//    @SendTo("/topic/chat")
//    public ChatMessage sendMessage(@Payload ChatMessage message) {
//        chatService.sendMessage(message);
//        return message;
//    }
//}