/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.cls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.parsing.api.Embedding;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.EmbeddingProvider;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

/**
 *
 * @author daimor
 */
public class clsEmbeddingProvider extends EmbeddingProvider {

    @Override
    public List<Embedding> getEmbeddings(Snapshot snapshot) {
        TokenHierarchy<?> tokenHierarchy = snapshot.getTokenHierarchy();
        TokenSequence<?> tokenSequence = tokenHierarchy.tokenSequence();
        if (tokenSequence == null) {
            return Collections.emptyList();
        }
        List<Embedding> embeddings = new ArrayList<>();

        while (tokenSequence.moveNext()) {
            Token<?> token = tokenSequence.token();
            if (token.id().name().contains("MethodDeclaration")) {
                int offset = token.offset(tokenHierarchy) + 2;
                int length = token.length() - 4;
                Embedding embedding = snapshot.create(offset, length, "text/isc-mac");
                embeddings.add(embedding);
            } else if (token.id().name().contains("XDataDeclaration")) {
                int offset = token.offset(tokenHierarchy) + 2;
                int length = token.length() - 4;
                Embedding embedding = snapshot.create(offset, length, "text/isc-xdata");
                embeddings.add(embedding);
            }
        }
        return embeddings;
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void cancel() {
    }

    public static final class Factory extends TaskFactory {

        @Override
        public Collection<SchedulerTask> create(final Snapshot snapshot) {
            return Collections.<SchedulerTask>singletonList(new clsEmbeddingProvider());
        }
    }
}
