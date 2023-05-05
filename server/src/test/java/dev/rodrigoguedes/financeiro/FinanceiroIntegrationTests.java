package dev.rodrigoguedes.financeiro;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import dev.rodrigoguedes.core.config.Profiles;

@SpringBootTest(classes = FinanceiroApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles({ Profiles.TEST })
@TestExecutionListeners(mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS, value = DbUnitTestExecutionListener.class)
@Transactional
@Rollback
public abstract class FinanceiroIntegrationTests implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
