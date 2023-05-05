package com.demo.service;

import com.demo.domain.*; // for static metamodels
import com.demo.domain.Blog;
import com.demo.repository.BlogRepository;
import com.demo.service.criteria.BlogCriteria;
import com.demo.service.dto.BlogDTO;
import com.demo.service.mapper.BlogMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Blog} entities in the database.
 * The main input is a {@link BlogCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BlogDTO} or a {@link Page} of {@link BlogDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BlogQueryService extends QueryService<Blog> {

    private final Logger log = LoggerFactory.getLogger(BlogQueryService.class);

    private final BlogRepository blogRepository;

    private final BlogMapper blogMapper;

    public BlogQueryService(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    /**
     * Return a {@link List} of {@link BlogDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BlogDTO> findByCriteria(BlogCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogMapper.toDto(blogRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BlogDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BlogDTO> findByCriteria(BlogCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogRepository.findAll(specification, page).map(blogMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BlogCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogRepository.count(specification);
    }

    /**
     * Function to convert {@link BlogCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Blog> createSpecification(BlogCriteria criteria) {
        Specification<Blog> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Blog_.id));
            }
            if (criteria.getTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitle(), Blog_.title));
            }
            if (criteria.getContent() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContent(), Blog_.content));
            }
        }
        return specification;
    }
}
