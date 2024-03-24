package com.ms.borrowingservice.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, String> {

}
