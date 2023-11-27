package org.sopt.watchapedia.domain.collection.service;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.collection.domain.Collection;
import org.sopt.watchapedia.domain.collection.domain.Reply;
import org.sopt.watchapedia.domain.collection.dto.request.ReplyDeleteRequest;
import org.sopt.watchapedia.domain.collection.dto.request.ReplySaveRequest;
import org.sopt.watchapedia.domain.collection.repository.CollectionRepository;
import org.sopt.watchapedia.domain.collection.repository.ReplyRepository;
import org.sopt.watchapedia.domain.user.domain.User;
import org.sopt.watchapedia.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.watchapedia.domain.collection.domain.Reply.createReply;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyService {
    private final UserRepository userRepository;
    private final CollectionRepository collectionRepository;
    private final ReplyRepository replyRepository;

    public void saveReply(Long collectionId, ReplySaveRequest replySaveRequest) {
        User findUser = findUser(replySaveRequest);
        Collection findCollection = findCollection(collectionId);
        Reply reply = createReply(replySaveRequest.content(), 0, findCollection, findUser);
        replyRepository.save(reply);
    }

    public void deleteReply(ReplyDeleteRequest replyDeleteRequest) {
        replyRepository.deleteById(replyDeleteRequest.replyId());
    }

    private User findUser(ReplySaveRequest replySaveRequest) {
        return userRepository.findByIdOrThrow(replySaveRequest.userId());
    }

    private Collection findCollection(Long collectionId) {
        return collectionRepository.findByIdOrThrow(collectionId);
    }
}
