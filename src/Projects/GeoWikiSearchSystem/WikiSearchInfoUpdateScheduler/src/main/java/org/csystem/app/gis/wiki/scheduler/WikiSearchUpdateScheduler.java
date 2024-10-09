package org.csystem.app.gis.wiki.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.scheduler.service.WikiSearchUpdateService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class WikiSearchUpdateScheduler {
    private final WikiSearchUpdateService m_wikiSearchUpdateService;

    public WikiSearchUpdateScheduler(WikiSearchUpdateService wikiSearchUpdateService)
    {
        m_wikiSearchUpdateService = wikiSearchUpdateService;
    }

    @Scheduled(cron = "0 51,52 20 * * *")
    public void schedule()
    {
        m_wikiSearchUpdateService.update();
    }
}
