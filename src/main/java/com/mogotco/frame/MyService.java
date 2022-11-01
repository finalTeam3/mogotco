package com.mogotco.frame;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface MyService<K, V> {
	@Transactional
	public void register(V v) throws Exception;

	@Transactional
	public void remove(K k) throws Exception;

	@Transactional
	public void modify(V v) throws Exception;

	@Transactional
	public V get(K k) throws Exception;

	@Transactional
	public List<V> get() throws Exception;
}
